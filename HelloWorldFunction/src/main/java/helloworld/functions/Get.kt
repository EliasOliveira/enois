package helloworld.functions

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import helloworld.GatewayResponse
import java.io.IOException

class Get : RequestHandler<Any?, Any> {



    override fun handleRequest(input: Any?, context: Context?): Any {
        val headers: MutableMap<String, String> = HashMap()
        headers["Content-Type"] = "application/json"
        headers["X-Custom-Header"] = "application/json"
        return try {
            val output = "{ \"message\": \"hello Get\", \"input\": \"$input\" }"
            GatewayResponse(output, headers, 200)
        } catch (e: IOException) {
            GatewayResponse("{}", headers, 500)
        }
    }

}