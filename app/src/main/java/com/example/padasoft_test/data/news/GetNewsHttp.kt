package com.example.padasoft_test.data.news


class GetNewsHttp(
    val status: Int,
    val message: String,
    val data: List<NewsHttp>
) {
    class NewsHttp(
        val id: Int,
        val uuid: String,
        val create: String,
        val title: String,
        val image: String,
        val detail: String
    ) {
        constructor(item: NewsHttp) : this(
            id = item.id,
            uuid = item.uuid,
            create = item.create,
            title = item.title,
            image = item.image,
            detail = item.detail
        )
    }
}
