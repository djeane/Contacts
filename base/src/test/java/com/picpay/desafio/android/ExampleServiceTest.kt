package com.picpay.desafio.android

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.features.contacts.api.service.UserListService
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse
import junit.framework.Assert.assertEquals
import org.junit.Test
import retrofit2.Call
import retrofit2.Response

class ExampleServiceTest {

    private val api = mock<UserListService>()

    private val service = ExampleService(api)

    @Test
    fun exampleTest() {
        // given
        val call = mock<Call<List<UserListResponse>>>()
        val expectedUsers = emptyList<UserListResponse>()

        whenever(call.execute()).thenReturn(Response.success(expectedUsers))
        whenever(api.getUserList()).thenReturn(call)

        // when
        val users = service.example()

        // then
        assertEquals(users, expectedUsers)
    }
}