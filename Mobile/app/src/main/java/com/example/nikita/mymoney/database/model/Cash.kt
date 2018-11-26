package com.example.nikita.mymoney.database.model

import android.content.ContentValues
import java.time.LocalDate

data class Cash(val id: Long? = null, val name: String, val categoryId: Long? = null,
                val cost: Double, val date: String = LocalDate.now().toString()) : Model() {
    override var tableName: String = TABLE_NAME

    companion object : Money() {
        const val TABLE_NAME: String = "Cash"
    }

    override val dbModel: ContentValues
        get() {
            val values = ContentValues()
            values.put(CATEGORY_ID, categoryId)
            values.put(COST, cost)
            values.put(NAME, name)
            values.put(DATE, date)
            return values
        }
}


data class CashDTO(var id: Long? = null, val category: Category, var name: String,
                   val cost: Double, val date: String = LocalDate.now().toString()) {
    override fun toString(): String {
        return "$name ${category.name} $cost $date"
    }
}


data class CashCategoryJoinTable(val cashId: Long, val categoryId: Long, val cashName: String, val categoryName: String, val cost: Double, val date: String)

