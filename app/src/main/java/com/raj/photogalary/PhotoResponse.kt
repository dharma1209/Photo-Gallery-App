package com.raj.photogalary

data class PhotoResponse(
    val total: Int? = null,
    val totalHits: Int? = null,
    val hits: List<PhotoSource>
)
