package com.example.googlesearchnewtechnologies.network.services.search
import com.google.gson.annotations.SerializedName


data class GoogleResponseDto(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("url")
    val url: UrlDto,
    @SerializedName("queries")
    val queries: QueriesDto,
    @SerializedName("context")
    val context: ContextDto,
    @SerializedName("searchInformation")
    val searchInformation: SearchInformationDto,
    @SerializedName("items")
    val items: List<ItemDto>
)

data class UrlDto(
    @SerializedName("type")
    val type: String,
    @SerializedName("template")
    val template: String
)

data class QueriesDto(
    @SerializedName("request")
    val request: List<RequestDto>
)

data class ContextDto(
    @SerializedName("title")
    val title: String
)

data class SearchInformationDto(
    @SerializedName("searchTime")
    val searchTime: Double,
    @SerializedName("formattedSearchTime")
    val formattedSearchTime: String,
    @SerializedName("totalResults")
    val totalResults: String,
    @SerializedName("formattedTotalResults")
    val formattedTotalResults: String
)

data class ItemDto(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("htmlTitle")
    val htmlTitle: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("displayLink")
    val displayLink: String,
    @SerializedName("snippet")
    val snippet: String,
    @SerializedName("htmlSnippet")
    val htmlSnippet: String,
    @SerializedName("cacheId")
    val cacheId: String,
    @SerializedName("formattedUrl")
    val formattedUrl: String,
    @SerializedName("htmlFormattedUrl")
    val htmlFormattedUrl: String,
    @SerializedName("pagemap")
    val pagemap: PagemapDto
)

data class RequestDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("totalResults")
    val totalResults: String,
    @SerializedName("searchTerms")
    val searchTerms: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("inputEncoding")
    val inputEncoding: String,
    @SerializedName("outputEncoding")
    val outputEncoding: String,
    @SerializedName("safe")
    val safe: String,
    @SerializedName("cx")
    val cx: String
)

data class PagemapDto(
    @SerializedName("cse_thumbnail")
    val cseThumbnail: List<CseThumbnailDto>,
    @SerializedName("metatags")
    val metatags: List<MetatagDto>,
    @SerializedName("cse_image")
    val cseImage: List<CseImageDto>
)

data class CseThumbnailDto(
    @SerializedName("src")
    val src: String,
    @SerializedName("width")
    val width: String,
    @SerializedName("height")
    val height: String
)

data class MetatagDto(
    @SerializedName("og:image")
    val ogImage: String,
    @SerializedName("og:title")
    val ogTitle: String,
    @SerializedName("yandex-verification")
    val yandexVerification: String,
    @SerializedName("og:url")
    val ogUrl: String,
    @SerializedName("og:description")
    val ogDescription: String,
    @SerializedName("application-name")
    val applicationName: String,
    @SerializedName("og:type")
    val ogType: String,
    @SerializedName("og:image:width")
    val ogImageWidth: String,
    @SerializedName("twitter:card")
    val twitterCard: String,
    @SerializedName("twitter:title")
    val twitterTitle: String,
    @SerializedName("mod")
    val mod: String,
    @SerializedName("og:site_name")
    val ogSiteName: String,
    @SerializedName("apple-mobile-web-app-title")
    val appleMobileWebAppTitle: String,
    @SerializedName("og:image:height")
    val ogImageHeight: String,
    @SerializedName("twitter:image")
    val twitterImage: String,
    @SerializedName("referrer")
    val referrer: String,
    @SerializedName("twitter:image:alt")
    val twitterImageAlt: String,
    @SerializedName("apple-mobile-web-app-status-bar-style")
    val appleMobileWebAppStatusBarStyle: String,
    @SerializedName("msapplication-tap-highlight")
    val msapplicationTapHighlight: String,
    @SerializedName("viewport")
    val viewport: String,
    @SerializedName("apple-mobile-web-app-capable")
    val appleMobileWebAppCapable: String,
    @SerializedName("mobile-web-app-capable")
    val mobileWebAppCapable: String,
    @SerializedName("og:locale")
    val ogLocale: String,
    @SerializedName("theme-color")
    val themeColor: String,
    @SerializedName("og:app_id")
    val ogAppId: String,
    @SerializedName("og:tag")
    val ogTag: String,
    @SerializedName("og:image:type")
    val ogImageType: String,
    @SerializedName("twitter:creator")
    val twitterCreator: String,
    @SerializedName("og:image:heigth")
    val ogImageHeigth: String,
    @SerializedName("twitter:site")
    val twitterSite: String,
    @SerializedName("og:published_time")
    val ogPublishedTime: String,
    @SerializedName("og:section")
    val ogSection: String,
    @SerializedName("msapplication-tilecolor")
    val msapplicationTilecolor: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("facebook-domain-verification")
    val facebookDomainVerification: String,
    @SerializedName("og:modified_time")
    val ogModifiedTime: String,
    @SerializedName("twitter:description")
    val twitterDescription: String,
    @SerializedName("publisher")
    val publisher: String
)

data class CseImageDto(
    @SerializedName("src")
    val src: String
)