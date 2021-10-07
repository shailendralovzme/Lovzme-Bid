package com.lovzme.lovzme2.ui.homefragment.response.productdetaiils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.lovzme.lovzme2.ui.homefragment.response.sallingresponse.Countdown;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Product implements Serializable {

    @SerializedName("id_product")
    @Expose
    public String idProduct;
    @SerializedName("id_supplier")
    @Expose
    public String idSupplier;
    @SerializedName("id_manufacturer")
    @Expose
    public String idManufacturer;
    @SerializedName("id_category_default")
    @Expose
    public String idCategoryDefault;
    @SerializedName("id_shop_default")
    @Expose
    public String idShopDefault;
    @SerializedName("id_tax_rules_group")
    @Expose
    public String idTaxRulesGroup;
    @SerializedName("on_sale")
    @Expose
    public String onSale;
    @SerializedName("online_only")
    @Expose
    public String onlineOnly;
    @SerializedName("ean13")
    @Expose
    public String ean13;
    @SerializedName("isbn")
    @Expose
    public String isbn;
    @SerializedName("upc")
    @Expose
    public String upc;
    @SerializedName("ecotax")
    @Expose
    public String ecotax;
    @SerializedName("quantity")
    @Expose
    public String quantity;
    @SerializedName("minimal_quantity")
    @Expose
    public String minimalQuantity;
    @SerializedName("low_stock_threshold")
    @Expose
    public Object lowStockThreshold;
    @SerializedName("low_stock_alert")
    @Expose
    public String lowStockAlert;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("wholesale_price")
    @Expose
    public String wholesalePrice;
    @SerializedName("unity")
    @Expose
    public String unity;
    @SerializedName("unit_price_ratio")
    @Expose
    public String unitPriceRatio;
    @SerializedName("additional_shipping_cost")
    @Expose
    public String additionalShippingCost;
    @SerializedName("reference")
    @Expose
    public String reference;
    @SerializedName("supplier_reference")
    @Expose
    public String supplierReference;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("width")
    @Expose
    public String width;
    @SerializedName("height")
    @Expose
    public String height;
    @SerializedName("depth")
    @Expose
    public String depth;
    @SerializedName("weight")
    @Expose
    public String weight;
    @SerializedName("out_of_stock")
    @Expose
    public String outOfStock;
    @SerializedName("additional_delivery_times")
    @Expose
    public String additionalDeliveryTimes;
    @SerializedName("quantity_discount")
    @Expose
    public String quantityDiscount;
    @SerializedName("customizable")
    @Expose
    public String customizable;
    @SerializedName("uploadable_files")
    @Expose
    public String uploadableFiles;
    @SerializedName("text_fields")
    @Expose
    public String textFields;
    @SerializedName("active")
    @Expose
    public String active;
    @SerializedName("redirect_type")
    @Expose
    public String redirectType;
    @SerializedName("id_type_redirected")
    @Expose
    public String idTypeRedirected;
    @SerializedName("available_for_order")
    @Expose
    public String availableForOrder;
    @SerializedName("available_date")
    @Expose
    public String availableDate;
    @SerializedName("show_condition")
    @Expose
    public String showCondition;
    @SerializedName("condition")
    @Expose
    public String condition;
    @SerializedName("show_price")
    @Expose
    public String showPrice;
    @SerializedName("indexed")
    @Expose
    public String indexed;
    @SerializedName("visibility")
    @Expose
    public String visibility;
    @SerializedName("cache_is_pack")
    @Expose
    public String cacheIsPack;
    @SerializedName("cache_has_attachments")
    @Expose
    public String cacheHasAttachments;
    @SerializedName("is_virtual")
    @Expose
    public String isVirtual;
    @SerializedName("cache_default_attribute")
    @Expose
    public String cacheDefaultAttribute;
    @SerializedName("date_add")
    @Expose
    public String dateAdd;
    @SerializedName("date_upd")
    @Expose
    public String dateUpd;
    @SerializedName("advanced_stock_management")
    @Expose
    public String advancedStockManagement;
    @SerializedName("pack_stock_type")
    @Expose
    public String packStockType;
    @SerializedName("state")
    @Expose
    public String state;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("description_short")
    @Expose
    public String descriptionShort;
    @SerializedName("available_now")
    @Expose
    public String availableNow;
    @SerializedName("available_later")
    @Expose
    public String availableLater;
    @SerializedName("link_rewrite")
    @Expose
    public String linkRewrite;
    @SerializedName("meta_description")
    @Expose
    public String metaDescription;
    @SerializedName("meta_keywords")
    @Expose
    public String metaKeywords;
    @SerializedName("meta_title")
    @Expose
    public String metaTitle;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("id_image")
    @Expose
    public String idImage;
    @SerializedName("legend")
    @Expose
    public String legend;
    @SerializedName("manufacturer_name")
    @Expose
    public String manufacturerName;
    @SerializedName("product_image")
    @Expose
    public String productImage;
    @SerializedName("price_tax_excl")
    @Expose
    public String priceTaxExcl;
    @SerializedName("price_tax_incl")
    @Expose
    public String priceTaxIncl;
    @SerializedName("price_reduction")
    @Expose
    public String priceReduction;
    @SerializedName("price_selling")
    @Expose
    public String priceSelling;
    @SerializedName("reduction_rate")
    @Expose
    public String reductionRate;
    @SerializedName("rate")
    @Expose
    public Object rate;
    @SerializedName("wishlist")
    @Expose
    public ProductDetailsWishlist wishlist;
    @SerializedName("countdown")
    @Expose
    public Countdown countdown;
    @SerializedName("product_image_list")
    @Expose
    public List<String> productImageList = null;
    @SerializedName("product_features_list")
    @Expose
    public List<ProductFeatures> productFeaturesList = null;
    @SerializedName("product_sizes")
    @Expose
    public List<ProductSize> productSizes = null;
    @SerializedName("color_code")
    @Expose
    public String colorCode;
    @SerializedName("multicolor_image")
    @Expose
    public String multicolorImage;

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(String idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(String idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

    public String getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(String idShopDefault) {
        this.idShopDefault = idShopDefault;
    }

    public String getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(String idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public String getOnSale() {
        return onSale;
    }

    public void setOnSale(String onSale) {
        this.onSale = onSale;
    }

    public String getOnlineOnly() {
        return onlineOnly;
    }

    public void setOnlineOnly(String onlineOnly) {
        this.onlineOnly = onlineOnly;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getEcotax() {
        return ecotax;
    }

    public void setEcotax(String ecotax) {
        this.ecotax = ecotax;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(String minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    public Object getLowStockThreshold() {
        return lowStockThreshold;
    }

    public void setLowStockThreshold(Object lowStockThreshold) {
        this.lowStockThreshold = lowStockThreshold;
    }

    public String getLowStockAlert() {
        return lowStockAlert;
    }

    public void setLowStockAlert(String lowStockAlert) {
        this.lowStockAlert = lowStockAlert;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(String wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getUnitPriceRatio() {
        return unitPriceRatio;
    }

    public void setUnitPriceRatio(String unitPriceRatio) {
        this.unitPriceRatio = unitPriceRatio;
    }

    public String getAdditionalShippingCost() {
        return additionalShippingCost;
    }

    public void setAdditionalShippingCost(String additionalShippingCost) {
        this.additionalShippingCost = additionalShippingCost;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(String outOfStock) {
        this.outOfStock = outOfStock;
    }

    public String getAdditionalDeliveryTimes() {
        return additionalDeliveryTimes;
    }

    public void setAdditionalDeliveryTimes(String additionalDeliveryTimes) {
        this.additionalDeliveryTimes = additionalDeliveryTimes;
    }

    public String getQuantityDiscount() {
        return quantityDiscount;
    }

    public void setQuantityDiscount(String quantityDiscount) {
        this.quantityDiscount = quantityDiscount;
    }

    public String getCustomizable() {
        return customizable;
    }

    public void setCustomizable(String customizable) {
        this.customizable = customizable;
    }

    public String getUploadableFiles() {
        return uploadableFiles;
    }

    public void setUploadableFiles(String uploadableFiles) {
        this.uploadableFiles = uploadableFiles;
    }

    public String getTextFields() {
        return textFields;
    }

    public void setTextFields(String textFields) {
        this.textFields = textFields;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRedirectType() {
        return redirectType;
    }

    public void setRedirectType(String redirectType) {
        this.redirectType = redirectType;
    }

    public String getIdTypeRedirected() {
        return idTypeRedirected;
    }

    public void setIdTypeRedirected(String idTypeRedirected) {
        this.idTypeRedirected = idTypeRedirected;
    }

    public String getAvailableForOrder() {
        return availableForOrder;
    }

    public void setAvailableForOrder(String availableForOrder) {
        this.availableForOrder = availableForOrder;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public String getShowCondition() {
        return showCondition;
    }

    public void setShowCondition(String showCondition) {
        this.showCondition = showCondition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    public String getIndexed() {
        return indexed;
    }

    public void setIndexed(String indexed) {
        this.indexed = indexed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getCacheIsPack() {
        return cacheIsPack;
    }

    public void setCacheIsPack(String cacheIsPack) {
        this.cacheIsPack = cacheIsPack;
    }

    public String getCacheHasAttachments() {
        return cacheHasAttachments;
    }

    public void setCacheHasAttachments(String cacheHasAttachments) {
        this.cacheHasAttachments = cacheHasAttachments;
    }

    public String getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(String isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getCacheDefaultAttribute() {
        return cacheDefaultAttribute;
    }

    public void setCacheDefaultAttribute(String cacheDefaultAttribute) {
        this.cacheDefaultAttribute = cacheDefaultAttribute;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(String dateUpd) {
        this.dateUpd = dateUpd;
    }

    public String getAdvancedStockManagement() {
        return advancedStockManagement;
    }

    public void setAdvancedStockManagement(String advancedStockManagement) {
        this.advancedStockManagement = advancedStockManagement;
    }

    public String getPackStockType() {
        return packStockType;
    }

    public void setPackStockType(String packStockType) {
        this.packStockType = packStockType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getAvailableNow() {
        return availableNow;
    }

    public void setAvailableNow(String availableNow) {
        this.availableNow = availableNow;
    }

    public String getAvailableLater() {
        return availableLater;
    }

    public void setAvailableLater(String availableLater) {
        this.availableLater = availableLater;
    }

    public String getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(String linkRewrite) {
        this.linkRewrite = linkRewrite;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getPriceTaxExcl() {
        return priceTaxExcl;
    }

    public void setPriceTaxExcl(String priceTaxExcl) {
        this.priceTaxExcl = priceTaxExcl;
    }

    public String getPriceTaxIncl() {
        return priceTaxIncl;
    }

    public void setPriceTaxIncl(String priceTaxIncl) {
        this.priceTaxIncl = priceTaxIncl;
    }

    public String getPriceReduction() {
        return priceReduction;
    }

    public void setPriceReduction(String priceReduction) {
        this.priceReduction = priceReduction;
    }

    public String getPriceSelling() {
        return priceSelling;
    }

    public void setPriceSelling(String priceSelling) {
        this.priceSelling = priceSelling;
    }

    public String getReductionRate() {
        return reductionRate;
    }

    public void setReductionRate(String reductionRate) {
        this.reductionRate = reductionRate;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    public ProductDetailsWishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(ProductDetailsWishlist wishlist) {
        this.wishlist = wishlist;
    }

    public Countdown getCountdown() {
        return countdown;
    }

    public void setCountdown(Countdown countdown) {
        this.countdown = countdown;
    }

    public List<String> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<String> productImageList) {
        this.productImageList = productImageList;
    }

    public List<ProductFeatures> getProductFeaturesList() {
        return productFeaturesList;
    }

    public void setProductFeaturesList(List<ProductFeatures> productFeaturesList) {
        this.productFeaturesList = productFeaturesList;
    }

    public List<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getMulticolorImage() {
        return multicolorImage;
    }

    public void setMulticolorImage(String multicolorImage) {
        this.multicolorImage = multicolorImage;
    }
}

