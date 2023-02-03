/**
 * 싱글톤패턴이란
 * 어떤 클래스가 최초 한번만 메모리를 할당하고(Static) 그 메모리에 객체를 만들어 사용하는 디자인 패턴
 */
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