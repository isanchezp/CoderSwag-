package com.ivan.section6.model

data class Category(val title: String, val image: String){

    override fun toString(): String {
        return title
    }
}

