package helloworld;


import helloworld.functions.Get
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GetTest {
    @Test
    fun isSuccessfulResponse() {
        val app = Get()
        val result: GatewayResponse = app.handleRequest(null, null) as GatewayResponse
        assertEquals(result.statusCode, 200)
        assertEquals(result.headers?.get("Content-Type"), "application/json")
        val content: String = result.body
        assertNotNull(content)
        assertTrue(content.contains("\"message\""))
        assertTrue(content.contains("\"hello world\""))
        assertTrue(content.contains("\"location\""))
    }
}
