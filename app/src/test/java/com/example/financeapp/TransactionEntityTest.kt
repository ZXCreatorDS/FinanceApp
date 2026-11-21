package com.example.financeapp

import org.junit.Assert.assertEquals
import org.junit.Test

internal class TransactionEntityTest {
    @Test
    fun entityRoundTripKeepsTransactionData() {
        val transaction = Transaction(
            amount = 250,
            type = TransactionType.EXPENSE,
            description = "Кофе",
        )

        val restored = TransactionEntity.fromTransaction(transaction).toTransaction()

        assertEquals(transaction, restored)
    }

    @Test
    fun converterKeepsTransactionType() {
        val converter = TransactionTypeConverter()

        val stored = converter.toStoredValue(TransactionType.INCOME)
        val restored = converter.fromStoredValue(stored)

        assertEquals("INCOME", stored)
        assertEquals(TransactionType.INCOME, restored)
    }
}
