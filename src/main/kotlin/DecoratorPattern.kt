/**
 * Decorator Pattern이란
 * - 객체에 추가적인 요건을 동적으로 첨가한다.
 * - 서브클래스를 만드는 것을 통해 기능을 유연하게 확장할 수 있는 방법을 제공한다.
 * - 객체에 추가적인 요건을 첨가할 때 서브클래스를 만드는 것보다 유연하고 캡슐화된 방법을 제공한다.
 */

interface CoffeMachine {
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}


/**
 * CoffeMachine을 구현하는 클래스
 * - NomalCoffeMachine은 makeSmallCoffee()와 makeLargeCoffee()를 구현한다.
 */
class NormalCoffeeMachine : CoffeMachine {
    override fun makeSmallCoffee() {
        println("Small Coffee")
    }

    override fun makeLargeCoffee() {
        println("Large Coffee")
    }
}

/**
 * kotlin에서는 by 키워드를 사용하여 인터페이스를 구현하는 클래스를 만들 수 있다.
 */
class EnhancedCoffeeMachine(private val coffeMachine: CoffeMachine) : CoffeMachine by coffeMachine {
    /**
     * makeSmallCoffee()는 기존의 NormalCoffeeMachine의 makeSmallCoffee()를 오버라이드한다.
     */
    override fun makeSmallCoffee() {
        println("Enhanced Small Coffee")
    }


    /**
     * makeCoffeeWithMilk()는 기존의 NormalCoffeeMachine의 makeSmallCoffee()를 확장한다.
     */
    fun makeCoffeeWithMilk() {
        addMilky()
        makeSmallCoffee()
    }

    /**
     * makeCoffeeWithMilk()에서 사용하는 함수
     */
    private fun addMilky() {
        println("Add Milky")
    }
}

fun main() {
    val normalMachine = NormalCoffeeMachine()
    val enhancedMachine = EnhancedCoffeeMachine(normalMachine)

    // non-overridden behaviour
    enhancedMachine.makeSmallCoffee()
    // overridden behaviour
    enhancedMachine.makeLargeCoffee()
    // extended behaviour
    enhancedMachine.makeCoffeeWithMilk()
}