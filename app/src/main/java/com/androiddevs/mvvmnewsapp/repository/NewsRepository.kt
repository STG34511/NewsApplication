package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article
import retrofit2.Retrofit
import java.util.Locale.IsoCountryCode

class NewsRepository(
    val db : ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String , pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)


    suspend fun getSearchNews(searchQuery:String , pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article:Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article:Article) = db.getArticleDao().deleteArticle(article)


}