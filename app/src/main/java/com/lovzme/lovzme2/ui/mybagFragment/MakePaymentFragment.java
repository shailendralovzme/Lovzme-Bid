package com.lovzme.lovzme2.ui.mybagFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.lovzme.lovzme2.R;
import com.lovzme.lovzme2.databinding.FragmentMakePaymentBinding;
import com.lovzme.lovzme2.prefrence.ConstantHelper;
import com.lovzme.lovzme2.prefrence.SharedPrefs;
import com.lovzme.lovzme2.ui.activity.CompletePaymentActivity;
import com.lovzme.lovzme2.ui.homefragment.viewModel.AddToCartViewModel;
import com.lovzme.lovzme2.ui.mybagFragment.activity.CheckoutActivity;
import com.lovzme.lovzme2.ui.mybagFragment.adapter.PaymentModeAdapter;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.OrderBody;
import com.lovzme.lovzme2.ui.mybagFragment.model.order.PaymentOrder;
import com.lovzme.lovzme2.ui.profileFragment.addressmodel.AddresslistData;
import com.razorpay.Checkout;
import org.json.JSONObject;
import es.dmoral.toasty.Toasty;


public class MakePaymentFragment extends Fragment {
    FragmentMakePaymentBinding binding;
    CheckoutActivity checkoutActivity = new CheckoutActivity();
    PaymentModeAdapter adapter;
    AddresslistData.Payload selectedAddress = new AddresslistData.Payload();
    AddToCartViewModel viewModel;
    public static final String EXTRA_CART_DETAILS = "cart_details";
    public static final String EXTRA_SELECT_ADDRESS = "select_address";
    public static final String EXTRA_PAYMENT_MODE = "payment_mode";
    public static final String EXTRA_TRANSACTION_ID = "transaction_id";


    public MakePaymentFragment() {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_make_payment, container, false);
        View view = binding.getRoot();

        viewModel = new ViewModelProvider(requireActivity()).get(AddToCartViewModel.class);
        Checkout.preload(requireActivity());

        initView();

        binding.setMakePayment(checkoutActivity.getCart_details());

        setupPaymentModeRecyclerView();

        binding.btnOrderNow.setOnClickListener(v -> {
            if (adapter.getPaymentMode() != null) {
                if (binding.cbNewsletter.isChecked()) {
                    if (selectedAddress != null) {
                        if (adapter.getPayment_mode_no() == 1) {
                            if (Double.parseDouble(checkoutActivity.getCart_details().getCartPriceTotal()) > 299) {

                             postOrder();

                            }else {
                                binding.tvCartCashOnDeliveryMsg.setVisibility(View.VISIBLE);
                                binding.tvCartCashOnDeliveryMsg.setText("* Your total amount is less than 299. Add more products for Cash on delivery.");

                            }
                        }else {
                            MakePayment();
                        }
                    } else {
                        Toasty.warning(checkoutActivity, "Please choose delivery address to continue !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toasty.warning(checkoutActivity, "Agree the terms & condition to continue !", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toasty.warning(checkoutActivity, "Please choose payment mode to continue!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void MakePayment() {
        PaymentOrder paymentOrder = new PaymentOrder();
        PaymentOrder.Order order = new PaymentOrder.Order(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER,getString(R.string.empty)),
                checkoutActivity.getCart_details().getIdCart(),SharedPrefs.getInstance().getString(ConstantHelper.secure_key,getString(R.string.empty)),
                "razorpay",SharedPrefs.getInstance().getString(ConstantHelper.ADDRESSID,getString(R.string.empty)),
                SharedPrefs.getInstance().getString(ConstantHelper.ADDRESSID,getString(R.string.empty)),"test msg cart id 515");

        paymentOrder.setOrder(order);
        viewModel.setOnlineOrderMutableLiveData(paymentOrder);

        viewModel.onlineorderListLiveData().observe(requireActivity(), orderList -> {
            if (orderList.getPayload().getOrder()!=null){
                Toasty.success(checkoutActivity, orderList.getMessage(), Toast.LENGTH_SHORT).show();
                razorpay(orderList.getPayload().getOrder().getOrderDetails().getIdOrder(),
                        orderList.getPayload().getOrder().getPaymentGateway().getRazorpay().getRazorpayOrderId());

            }

        });



    }

    public void setupPaymentModeRecyclerView() {
        DividerItemDecoration itemDecor = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.addItemDecoration(itemDecor);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PaymentModeAdapter(getContext());
        recyclerView.setAdapter(adapter);
    }

    public void initView() {
        checkoutActivity = (CheckoutActivity) getActivity();

    }


    private void postOrder() {
        OrderBody orderBody = new OrderBody();
        OrderBody.Order order = new OrderBody.Order(SharedPrefs.getInstance().getString(ConstantHelper.KEY_CUSTOMER, getString(R.string.empty)),
             checkoutActivity.getCart_details().getIdCart(),SharedPrefs.getInstance().getString(ConstantHelper.secure_key,getString(R.string.empty)),
                "COD",SharedPrefs.getInstance().getString(ConstantHelper.ADDRESSID,getString(R.string.empty)),
                SharedPrefs.getInstance().getString(ConstantHelper.ADDRESSID,getString(R.string.empty)), "test msg cart id 511");

        orderBody.setOrder(order);
        viewModel.setOrderListMutableLiveData(orderBody);

        viewModel.orderListLiveData().observe(requireActivity(), orderList -> {
            if (orderList.getSuccess()!=null){
                Toasty.success(checkoutActivity, orderList.getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(requireContext(), CompletePaymentActivity.class);
                intent.putExtra(EXTRA_CART_DETAILS,checkoutActivity.getCart_details());
                intent.putExtra(EXTRA_SELECT_ADDRESS,selectedAddress);
                intent.putExtra(EXTRA_PAYMENT_MODE, "");
               intent.putExtra(EXTRA_TRANSACTION_ID,"");

                startActivity(intent);

            }
        });
    }

    private void razorpay(String order_id,String razorpay_orderid){
        Log.e("gsgdgdgssdsd", "razorpay: "+ "razorpay");
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_iVXtE3UNZEvT1A");
       checkout.setImage(R.drawable.order);
     //   final Activity activity = getActivity();

        double amount = Double.parseDouble(checkoutActivity.getCart_details().getCartTotal())*100;

        try {
            JSONObject options = new JSONObject();
            options.put("name", "Juvenca Online pvt ltd");
            options.put("description", order_id);
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
          options.put("order_id",razorpay_orderid);
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount",amount);
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            JSONObject preFill = new JSONObject();
            preFill.put("email", SharedPrefs.getInstance().getString(ConstantHelper.EMAIL,getString(R.string.empty)));
            preFill.put("contact", SharedPrefs.getInstance().getString(ConstantHelper.MOBILE_NO,getString(R.string.empty)));

            options.put("prefill", preFill);

            checkout.open(requireActivity(), options);



        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }

    }






}