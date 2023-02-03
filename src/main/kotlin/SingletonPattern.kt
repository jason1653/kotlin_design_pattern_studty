class Singleton private constructor() {
    companion object {
        private var instance: Singleton? = null

        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }
            return instance!!
        }
    }
}

fun main(args: Array<String>) {
    val singleton = Singleton.getInstance()
    val singleton2 = Singleton.getInstance()
    println(singleton == singleton2)
}