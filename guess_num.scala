/*
Filename: guess_num
Created: Siddhesh Salvi
Change history:4.2.2020 / Siddhesh Salvi
10. Question to find your number
a. Desc -> takes a command-line argument N, asks you to think of a number
between 0 and N-1, where N = 2^n, and always guesses the answer with n
questions.
b. I/P -> the Number N and then recursively ask true/false if the number is between
a high and low value
c. Logic -> Use Binary Search to find the number
d. O/P -> Print the intermediary number and the final answer
*/

import java.lang.Math
object guess_num {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("Enter a number between 0 and 31 : ")
        val num = scala.io.StdIn.readInt()
        val zero = 0

        if(num > 31 || num < 0){
          print("please enter valid input \n")
        }else {
          var max = math.pow(2, num).toInt
          print("Guess the number between " + zero + " and " + max+"\n")
          guessTheNum(zero,max)
          flag = false
        }
      }
      catch{
        case _=>print("Something went wrong Error occurred.\n")
      }
    }
  }

  //Function to guess the number in binary search way
  def guessTheNum(min: Int, max: Int):Unit={
    var mid = (max + min ) / 2
    if(min == max){
      print("Number is "+min)
    }
    else{
      //print("Min : "+min+" Max : "+max+"\n")
      print("Is it "+mid+" ? Enter y for Yes and any key for No : ")
      if(scala.io.StdIn.readLine().equalsIgnoreCase("y")){
        print("I guessed the Number.")
      }else{
        print("Is it less than "+mid+" ? Enter y for Yes and any key for No : ")
        if(scala.io.StdIn.readLine().equalsIgnoreCase("y")){
          guessTheNum(min,mid-1)
        }else{
          guessTheNum(mid+1,max)
        }
      }
    }

  }
}