/**
 */
interface OrderCommand {
    fun execute()
}


/**
 * OrderAddComand와 OrderPayCommand는 OrderCommand를 구현한다.
 */
class OrderAddComand(val order: Long) : OrderCommand {
    override fun execute() {
        println("Adding order with id: $order")
    }
}


/**
 * OrderAddComand와 OrderPayCommand는 OrderCommand를 구현한다.
 */
class OrderPayCommand(val id: Long) : OrderCommand {
    override fun execute() {
        println("Paying for order with id: $id")
    }
}


/**
 * CommandProcessor는 OrderCommand를 받아서 실행한다.
 */
class CommandProcessor {
    var queue = mutableListOf<OrderCommand>()

    /**
     * addToQueue는 자기 자신을 반환한다.
     */
    fun addToQueue(command: OrderCommand): CommandProcessor {
        queue.add(command)
        return this
    }


    /**
     * processCommands는 자기 자신을 반환한다.
     */
    fun processCommands(): CommandProcessor {
        queue.forEach { it.execute() }
        queue.clear()
        return this
    }
}


fun main(args: Array<String>) {
    /**
     * CommandProcessor를 생성하고 OrderAddComand와 OrderPayCommand를 추가한다.
     */
    CommandProcessor()
        .addToQueue(OrderAddComand(1))
        .addToQueue(OrderAddComand(2))
        .addToQueue(OrderPayCommand(1))
        .addToQueue(OrderPayCommand(2))
        .processCommands()
}