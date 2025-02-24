import kotlinx.coroutines.*
import kotlin.system.*

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            println(getWeatherReport())
            println("Have a good day!")

        }
    }
    // task 1
    //println("Execution time: ${time / 1000.0} seconds")
}

suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}
suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
} 

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    //task 1
    /*val temperature = async {
        try {
            getTemperature()
        } catch (e: AssertionError) {
            println("Caught exception $e")
            "{ No temperature found }"
        }
    } */
    // task 2
    val temperature = async { getTemperature() }
    delay(200)
    temperature.cancel()
    //task 1
    //"${forecast.await()} ${temperature.await()}"
    // task 2
    "${forecast.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
    //task 1
    //throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}
