/**
 * kotlin에서는 open class를 사용하여 상속을 허용한다.
 */
open class Eqipment(
    open val price: Int,
    val name: String
)

open class Composite(name: String) : Eqipment(0, name) {
    private val equipments = ArrayList<Eqipment>()

    /**
     * price는 getter를 통해 계산한다.
     */
    override val price: Int
        get() = equipments.map {
            it.price
        }.sum()

    /**
     * add는 apply를 통해 자기 자신을 반환한다.
     */
    fun add(equipment: Eqipment) = apply { equipments.add(equipment) }

}

/**
 * PersonalComputer는 Composite를 상속받는다.
 */
class PersonalComputer : Composite("PC")

/**
 * Processor, HardDrive, Memory는 Eqipment를 상속받는다.
 */
class Processor : Eqipment(1070, "Processor")

/**
 * HardDrive, Memory는 Eqipment를 상속받는다.
 */
class HardDrive : Eqipment(250, "Hard Drive")

/**
 * HardDrive, Memory는 Eqipment를 상속받는다.
 */
class Memory : Eqipment(280, "Memory")



fun main(args: Array<String>) {

    /**
     * PersonalComputer를 생성하고 Processor, HardDrive, Memory를 추가한다.
     */
    val pc = PersonalComputer()
    pc.add(Processor())
    pc.add(HardDrive())
    pc.add(Memory())

    /**
     * price를 출력한다.
     */
    println(pc.price)
}