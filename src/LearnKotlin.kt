fun getScore(name:String)=when(name){
    "Tom"->86
    "Jim"->77
    "Jack"->95
    else -> 0
}

fun checkNumber(num:Number){
    when(num){
        is Int->println("number is Int")
        is Double->println("number is Double")
        else->println("number not support")
    }
}

fun main() {
    //条件控制
    val num = 10L
    val name = "Jack"
    println(getScore(name))
    checkNumber(num)

    //for-in循环
    for (i in 0..10)
        println(i)
    for (i in 0 until 10 step 2)
        println(i)
    for(i in 10 downTo 1)
        print(i.toString()+" ")

    //
}
