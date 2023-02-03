/**
 * memento 패턴이란
 * 객체의 상태를 저장하고 복원하는 패턴이다.
 * kotlin data class는 getter, setter, equals, hashCode, toString을 자동으로 생성한다.
 */
data class Memento(val state: String)

/**
 * Originator는 Memento를 생성하고 저장한다.
 */
class Originator(var state: String) {

    /**
     * Memento를 생성한다.
     */
    fun createMemento(): Memento {
        return Memento(state)
    }

    /**
     * Memento를 저장한다.
     */
    fun restore(memento: Memento) {
        state = memento.state
    }
}


class CareTaker {

    /**
     * mutableListOf는 java의 ArrayList와 같다.
     */
    private val mementoList = mutableListOf<Memento>()

    /**
     * Memento를 저장한다.
     */
    fun saveState(memento: Memento) {
        mementoList.add(memento)
    }

    /**
     * Memento를 가져온다.
     */
    fun restore(index: Int): Memento {
        return mementoList[index]
    }
}

fun main() {
    val originator = Originator("initial state")
    val careTaker = CareTaker()
    careTaker.saveState(originator.createMemento())

    originator.state = "State #1"
    originator.state = "State #2"
    careTaker.saveState(originator.createMemento())

    originator.state = "State #3"
    println("Current State: " + originator.state)

    originator.restore(careTaker.restore(1))
    println("Second saved state: " + originator.state)

    originator.restore(careTaker.restore(0))
    println("First saved state: " + originator.state)
}