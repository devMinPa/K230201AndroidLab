
class Test {


}

open class Super{
    open var data= 10
    open fun some(){
        println("i am Super: $data")
    }
}

val obj= object :Super(){
    override var data=20
    override fun some(){
    println("i am Super2 재사용한 값 : $data")
    }
}

fun main(){
    obj.data=20
    println(obj.some())
    var data8= "abcd"
    when(data8){
        "10" -> println("data8의 값은 10")
        "abc" -> println("data8의 값은 abc")
        else ->{
            println("data9의 값은 ??")
        }
    }
    println("hello")
}