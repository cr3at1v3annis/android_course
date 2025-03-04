// Task 1
data class Event(
    val title: String, 
    val description: String? = null,
    val daypart : Daypart,
    val duration: Int,
    
)
// Task 2
enum class Daypart{
    MORNING,
    AFTERNOON,
    EVENING,
}
// Task 7
val Event.durationOfEvent: String
    	get() = if (this.duration < 60) {
        "short"
    } else {
        "long"
    }

fun main() {    
    // Task 3
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, duration = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, duration = 45)
    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)
    // Task 4
    val shortEvents = events.filter{it.duration < 60}
    println("You have ${shortEvents.size} events.")
    // Task 5
    val partedEvents = events.groupBy{it.daypart}
    partedEvents.forEach {(daypart, events) ->
        println("$daypart: ${events.size} events")
    }
    // Task 6
    println("Last event of the day: ${events.last().title}")
    // Task 7
    
    println("Duration of first event of the day: ${events[0].durationOfEvent}")

}
