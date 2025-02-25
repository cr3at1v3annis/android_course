import kotlinx.coroutines.*
import kotlin.system.*

fun main() {
    // Task 1
    println("Use the val keyword when the value doesn't change.")
    println("Use the var keyword when the value can change.")
    println("When you define a function, you define the parameters that can be passed to it.")
    println("When you call a function, you pass arguments for the parameters")
    // Task 2
    println("New chat message from a friend")
    // Task 3
    var discountPercentage: Int = 0
    var offer: String = ""
    val item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to ${discountPercentage} discount on ${item}! Hurry up!"
    
    println(offer)
    // Task 4
    val numberOfAdults = 20
    val numberOfKids = 30
    val total = numberOfAdults + numberOfKids
    println("The total party size is: ${total}")
    // Task 5
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = baseSalary + bonusAmount
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
    // Task 6.1
    /*val firstNumber = 10
    val secondNumber = 5
    println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}")*/
    // Task 6.2
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8
    
    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)
    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
    
    // Task 6.3
    val result_substract = substract(firstNumber, secondNumber)
    val anotherResult_substract = substract(firstNumber, thirdNumber)
    println("$firstNumber - $secondNumber = $result_substract")
    println("$firstNumber - $thirdNumber = $anotherResult_substract")
    
    // Task 7.1
    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"

    println(displayAlertMessage(operatingSystem, emailId))
    
    // Task 7.2
    val firstUserEmailId = "user_one@gmail.com"

    // The following line of code assumes that you named your parameter as emailId. 
    // If you named it differently, feel free to update the name.
    println(displayAlertMessage(emailId = firstUserEmailId))
    println()

    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"

    println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
    println()

    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"

    println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
    println()
    // Task 8
    val steps = 4000
    val caloriesBurned = pedometerStepsToCalories(steps);
    println("Walking $steps steps burns $caloriesBurned calories") 
    // Task 9
    var timeSpentToday = 300
    var timeSpentYesterday = 250
    println(compareTwoNumbers(timeSpentToday, timeSpentYesterday))
    timeSpentYesterday = 300
    println(compareTwoNumbers(timeSpentToday, timeSpentYesterday))
    timeSpentToday = 200
    timeSpentYesterday = 220
    println(compareTwoNumbers(timeSpentToday, timeSpentYesterday))
    
    // Task 10
    printInfoAboutCity("Ankara", 27, 31, 82)
    printInfoAboutCity("Tokyo", 32, 36, 18)
    printInfoAboutCity("Cape Town", 59, 64, 2)
    printInfoAboutCity("Guatemala City", 50, 55, 7)

}
// Task 6.2
fun add(first : Int, second : Int) : Int {
    return first + second
}
// Task 6.3
fun substract(first : Int, second : Int) : Int {
    return first - second
}
// Tasks 7.1 and 7.2
fun displayAlertMessage(operatingSystem: String = "Unknown OS", emailId: String = "unknown email") : String{
    return "There's a new sign-in request on ${operatingSystem} for your Google Account ${emailId}."
}
// Task 8
fun pedometerStepsToCalories(numberOfSteps: Int): Double {
    val caloriesBurnedForEachStep = 0.04
    val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
    return totalCaloriesBurned
}
// Task 9
fun compareTwoNumbers(timeSpentToday : Int, timeSpentYesterday : Int) : Boolean {
    return timeSpentToday > timeSpentYesterday
}
// Task 10
fun printInfoAboutCity(cityName: String, lowTemp: Int, highTemp: Int, chanceOfRain: Int) {
    println("City: $cityName")
    println("Low temperature: $lowTemp, High temperature: $highTemp")
    println("Chance of rain: $chanceOfRain %")
    println()
}

