/*
Filename: bubble_generics
Created: Siddhesh Salvi
Change history:7.2.2020 / Siddhesh Salvi

9. Rewrite Use Generics for Search and Sort Algorithms
*/


object bubble_generics {
  def main(args: Array[String]): Unit = {
    var flag = true
    while (flag) {
      try {
        print("How many words do you want to sort ? : ")
        var num = scala.io.StdIn.readInt()
        var words = new Array[String](num)
        println("Enter " + num + " words \n")
        for (i <- 0 until num) {
          println((i + 1) + " :  ")
          words(i) = scala.io.StdIn.readLine()
        }
        print("Input words are " + words.mkString(" "))
        flag = false
        sort_bubble(words)
      }
      catch {
        case _ => print("Something went wrong Error occurred.")
      }
    }
  }

  //Function to sort words by bubble sort
  def sort_bubble(data: Array[String]): Unit = {
    var t = ""
    for (i <- 0 until data.length - 1) {
      for (j <- 0 until data.length - i - 1) {
        if (data(j).compareTo(data(j + 1)) > 0) {
          t = data(j)
          data(j) = data(j + 1)
          data(j + 1) = t
        }
      }
    }
    print("\nsorted words are " + data.mkString(" "))
  }
} 