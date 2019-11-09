package com.example.Paging.data.model


import com.google.gson.annotations.SerializedName

data class RestaurantX(
    @SerializedName("R")
    var r: R,
    @SerializedName("apikey")
    var apikey: String,
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("location")
    var location: Location,
    @SerializedName("switch_to_order_menu")
    var switchToOrderMenu: Int,
    @SerializedName("cuisines")
    var cuisines: String,
    @SerializedName("timings")
    var timings: String,
    @SerializedName("average_cost_for_two")
    var averageCostForTwo: Int,
    @SerializedName("price_range")
    var priceRange: Int,
    @SerializedName("currency")
    var currency: String,
    @SerializedName("highlights")
    var highlights: List<Any>,
    @SerializedName("offers")
    var offers: List<Any>,
    @SerializedName("opentable_support")
    var opentableSupport: Int,
    @SerializedName("is_zomato_book_res")
    var isZomatoBookRes: Int,
    @SerializedName("mezzo_provider")
    var mezzoProvider: String,
    @SerializedName("is_book_form_web_view")
    var isBookFormWebView: Int,
    @SerializedName("book_form_web_view_url")
    var bookFormWebViewUrl: String,
    @SerializedName("book_again_url")
    var bookAgainUrl: String,
    @SerializedName("thumb")
    var thumb: String,
    @SerializedName("user_rating")
    var userRating: UserRating,
    @SerializedName("all_reviews_count")
    var allReviewsCount: Int,
    @SerializedName("photos_url")
    var photosUrl: String,
    @SerializedName("photo_count")
    var photoCount: Int,
    @SerializedName("photos")
    var photos: List<Photo>,
    @SerializedName("menu_url")
    var menuUrl: String,
    @SerializedName("featured_image")
    var featuredImage: String,
    @SerializedName("has_online_delivery")
    var hasOnlineDelivery: Int,
    @SerializedName("is_delivering_now")
    var isDeliveringNow: Int,
    @SerializedName("include_bogo_offers")
    var includeBogoOffers: Boolean,
    @SerializedName("deeplink")
    var deeplink: String,
    @SerializedName("is_table_reservation_supported")
    var isTableReservationSupported: Int,
    @SerializedName("has_table_booking")
    var hasTableBooking: Int,
    @SerializedName("events_url")
    var eventsUrl: String,
    @SerializedName("phone_numbers")
    var phoneNumbers: String,
    @SerializedName("all_reviews")
    var allReviews: AllReviews,
    @SerializedName("establishment")
    var establishment: List<String>,
    @SerializedName("establishment_types")
    var establishmentTypes: List<Any>



) {
    override fun toString(): String {
        return "RestaurantX(r=$r, apikey='$apikey', id='$id', name='$name', url='$url', location=$location, switchToOrderMenu=$switchToOrderMenu, cuisines='$cuisines', timings='$timings', averageCostForTwo=$averageCostForTwo, priceRange=$priceRange, currency='$currency', highlights=$highlights, offers=$offers, opentableSupport=$opentableSupport, isZomatoBookRes=$isZomatoBookRes, mezzoProvider='$mezzoProvider', isBookFormWebView=$isBookFormWebView, bookFormWebViewUrl='$bookFormWebViewUrl', bookAgainUrl='$bookAgainUrl', thumb='$thumb', userRating=$userRating, allReviewsCount=$allReviewsCount, photosUrl='$photosUrl', photoCount=$photoCount, photos=$photos, menuUrl='$menuUrl', featuredImage='$featuredImage', hasOnlineDelivery=$hasOnlineDelivery, isDeliveringNow=$isDeliveringNow, includeBogoOffers=$includeBogoOffers, deeplink='$deeplink', isTableReservationSupported=$isTableReservationSupported, hasTableBooking=$hasTableBooking, eventsUrl='$eventsUrl', phoneNumbers='$phoneNumbers', allReviews=$allReviews, establishment=$establishment, establishmentTypes=$establishmentTypes)"
    }
}