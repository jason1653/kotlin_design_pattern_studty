/**
 * Abstract Factory이란
 * - 객체 생성을 추상화하는 패턴
 * - 객체 생성을 위한 인터페이스를 제공하고, 이를 구현한 클래스를 통해 객체를 생성한다.
 */

interface Plant

/**
 * OrangePlant과 ApplePlant는 Plant를 구현한다.
 */
class OrangePlant : Plant


/**
 * OrangePlant과 ApplePlant는 Plant를 구현한다.
 */
class ApplePlant : Plant

abstract class PlantFactory {
    abstract fun makePlant(): Plant

    /**
     * companion object는 클래스 내부에 선언된 객체이다.
     * companion object는 클래스의 인스턴스를 생성하지 않고도 접근할 수 있다.
     * companion object는 클래스 내부에 하나만 선언할 수 있다.
     * companion object는 클래스 이름으로 접근할 수 있다.
     * companion object는 클래스가 로드될 때 초기화된다.
     * companion object는 클래스 내부의 다른 멤버들을 사용할 수 있다.
     * companion object는 클래스 내부의 다른 멤버들보다 먼저 초기화된다.
     */
    companion object {

        /**
         * inline 함수는 함수를 호출하는 곳에 함수의 내용을 복사해 넣는다.
         * inline 함수는 함수의 인자로 람다식을 받을 수 있다.
         * inline 함수는 함수의 인자로 람다식을 받을 때, 람다식의 내용을 복사해 넣는다.
         *
         * reified 키워드를 사용하면 inline 함수의 인자로 받은 람다식의 타입을 알 수 있기 때문에 타입을 비교할 수 있고, 타입을 비교할 수 있기 때문에 when을 사용할 수 있다.
         */
        inline fun <reified T : Plant> createFactory(): PlantFactory {
            return when (T::class) {
                OrangePlant::class -> OrangeFactory()
                ApplePlant::class -> AppleFactory()
                else -> throw IllegalArgumentException("Unknown Plant type")
            }
        }
    }
}

class AppleFactory : PlantFactory() {
    override fun makePlant(): Plant = ApplePlant()
}

class OrangeFactory : PlantFactory() {
    override fun makePlant(): Plant = OrangePlant()
}


fun main() {
    val plantFactory = PlantFactory.createFactory<OrangePlant>()
    val plant = plantFactory.makePlant()
    println("Created plant: $plant")
}