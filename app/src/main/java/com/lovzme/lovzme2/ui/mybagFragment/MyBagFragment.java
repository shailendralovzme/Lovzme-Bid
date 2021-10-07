package com.lovzme.lovzme2.ui.mybagFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.application.LovzMe2App;
import com.lovzme.lovzme2.databinding.FragmentMyBagBinding;
import com.lovzme.lovzme2.interFace.MyOnItemClickListner;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.homefragment.viewModel.AddToCartViewModel;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.CartDetails;
import com.lovzme.lovzme2.ui.mybagFragment.activity.CheckoutActivity;
import com.lovzme.lovzme2.ui.mybagFragment.adapter.CartAdapter;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.CartProduct;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.Wallet;
import com.lovzme.lovzme2.ui.mybagFragment.addToCart.body.UpdateCartBody;
import com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBalance;
import com.lovzme.lovzme2.ui.mybagFragment.model.wallet.WalletBody.WalletBody;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class MyBagFragment extends Fragment {
    FragmentMyBagBinding binding;
    ArrayList<CartProduct> cart_products = new ArrayList<>();
    AddToCartViewModel viewModel;
    CartAdapter cartAdapter;
    CartDetails cartDetails;
    WalletBalance.Wallet wallet = new WalletBalance.Wallet();
    Wallet wallet1;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_bag, container, false);
        View view = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(AddToCartViewModel.class);

        binding.btnCheckout.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), CheckoutActivity.class);
            intent.putExtra(CheckoutActivity.EXTRAS_CART_DETAILS, cartDetails);
            startActivity(intent);
        });

        binding.swipeToRefresh.setOnRefreshListener(this::getCartdetails);
        binding.swipeToRefresh.setColorSchemeResources(R.color.colorAccent,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);



        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();
        getCartdetails();
        addWalletBalance();
        binding.btnWallet.setOnClickListener(v -> redeemWallet(binding.edtCoin.getText().toString()));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getCartdetails() {
        viewModel.setGetCartToAddMutableLiveData();
        viewModel.getCartToAddLiveData().observe((LifecycleOwner) requireContext(), getCartToAdd -> {
            if (getCartToAdd.getPayload() != null) {
                showCartView();
                cart_products.clear();
                cart_products.addAll(getCartToAdd.getPayload().getCart().getCartProducts());
                if (binding.swipeToRefresh.isRefreshing()) {
                    binding.swipeToRefresh.setRefreshing(false);
                }
                binding.recylerView.setLayoutManager(new LinearLayoutManager(getContext()));
                cartAdapter = new CartAdapter(getContext(), cart_products, MyBagFragment.this::upDateCartDeails);
                binding.recylerView.setAdapter(cartAdapter);
                cartAdapter.notifyDataSetChanged();
                cartAdapter.setListener(new MyOnItemClickListner() {
                    @Override
                    public void onRemoveClick(int position) {
                        deleteCartDialog(position);

                    }

                    @Override
                    public void onEditClick(int position) {

                    }
                });

                setupInvoiceBill(getCartToAdd.getPayload().getCart().getCartDetails(),getCartToAdd.getPayload().getCart().getWallet());

            } else {
                showEmptyCartView();
            }
        });
    }

    public void deleteCartDialog(int adapterPosition) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(requireActivity());
        alertDialog.setTitle("Delete");
        alertDialog.setMessage("Are you sure you want to remove this product from cart?");
        alertDialog.setIcon(R.drawable.ic_delete_primary);
        alertDialog.setPositiveButton("delete", (dialog, which) -> {
            DeleteCart(cart_products.get(adapterPosition), adapterPosition);
            getCartdetails();
            dialog.dismiss();
        });
        alertDialog.setNegativeButton("no", (dialog, which) -> dialog.cancel());
        alertDialog.show();
    }

    private void DeleteCart(CartProduct cartProduct, int adapterPosition) {
        AddToCartViewModel deleteAddressViewModel = new ViewModelProvider(this).get(AddToCartViewModel.class);
        deleteAddressViewModel.setDeleteMutableLiveData(cartProduct.getIdCart(), cartProduct.getIdProduct()
                , cartProduct.getIdProductAttribute());
        deleteAddressViewModel.deleteCartItemLiveData().observe(this, deleteAddressData -> {
            if (deleteAddressData.getPayload() != null) {
                Toasty.success(requireContext(), "Cart Delete Successfull", Toast.LENGTH_SHORT).show();
                cartAdapter.removeCartItem(adapterPosition);
            }
        });
    }

    public void upDateCartDeails(CartProduct cart_products, int quantity, int position) {
        UpdateCartBody updateCartBody = new UpdateCartBody();
        UpdateCartBody.Cart updatecart = new UpdateCartBody.Cart(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, getString(R.string.empty)),
                "0", "0", cart_products.getIdProduct(), cart_products.getIdProductAttribute()
                , String.valueOf(quantity), SharedPrefs.getInstance().getString(ConstantHelper.secure_key, getString(R.string.empty)));
        updateCartBody.setCart(updatecart);
        viewModel.setupdateCartMutableLiveData(updateCartBody);

        viewModel.updateCartItemLiveData().observe(requireActivity(), addToCart -> {
            if (addToCart.getPayload() != null) {
                setupInvoiceBill(addToCart.getPayload().getCart().getCartDetails(),addToCart.getPayload().getCart().getWallet());
                updateQty_Price(addToCart.getPayload().getCart().getCartProducts().get(position), position);

            }
        });

    }


    public void setupInvoiceBill(CartDetails cart_details, Wallet wallet) {
        this.cartDetails = cart_details;
       this.wallet1 = wallet;
        binding.setCartDetail(cart_details);
        binding.setWallet(wallet);
        publishCartItemCount(cart_details.getQuantityTotal());

    }

    public void publishCartItemCount(String badgeCount) {
        EventBus.getDefault().post(badgeCount);
    }

    public void updateQty_Price(CartProduct product, int position) {
        cartAdapter.updateQty_Price(product, position);
    }

    public void showEmptyCartView() {
        binding.emptyBagLayout.setVisibility(View.VISIBLE);
        binding.RlProductView.setVisibility(View.GONE);

    }

    public void showCartView() {
        binding.RlProductView.setVisibility(View.VISIBLE);
        binding.emptyBagLayout.setVisibility(View.GONE);

    }

    private void addWalletBalance() {
        viewModel.setWalletBalanceMutableLiveData();
        viewModel.walletBalanceLiveData().observe(requireActivity(), walletBalance -> {
            if (walletBalance.getSuccess()) {
                wallet = walletBalance.getWallet();
                binding.TVWalletAmount.setText(wallet.getBalance());
            }
        });
    }

    private void redeemWallet(String redeemAmt){
        WalletBody walletBody = new WalletBody();
        WalletBody.Wallet redeemwallet =  new WalletBody.Wallet(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,getString(R.string.empty))
                , cartDetails.getIdCart(), redeemAmt,
                SharedPrefs.getInstance().getString(ConstantHelper.secure_key,getString(R.string.empty)));
        walletBody.setWallet(redeemwallet);

        viewModel.setRedeemWalletMutableLiveData(walletBody);
        viewModel.getRedeemWalletLiveData().observe(requireActivity(), addToCart -> {
            if (addToCart.getSuccess()){
                getCartdetails();
                Toasty.success(requireContext(), addToCart.getMessage(), Toast.LENGTH_SHORT,true).show();
            }else {
                Toasty.error(requireContext(), "Insufficient  Balance", Toast.LENGTH_SHORT,true).show();
            }

        });
    }


    private void deleteWallet(){
        viewModel.setDeleteWalletMutableLiveData(cartDetails.getIdCart());
        viewModel.getDeleteWalletLiveData().observe(requireActivity(), addToCart -> {
            if (addToCart.getSuccess()){
                getCartdetails();
                LovzMe2App.hideBidProgressDialog();
                Toasty.success(requireContext(), addToCart.getMessage(), Toast.LENGTH_SHORT,true).show();
            }
        });
    }


}