/*
Filename: string_permutation
Created: Siddhesh salvi
Change history:1.2.2020 / Siddhesh Salvi
1. Write static functions to return all permutations of a String using iterative method and
Recursion method. Check if the arrays returned by two string functions are equal.
 */

import java.util
import scala.collection.mutable
object string_permutation {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("Enter string to find its permutations : ")
        var word = scala.io.StdIn.readLine()
        recursivePermute(word.toCharArray(),0)
        iterativePermute(word)
        flag = false
      }
      catch{
        case _=>print("Something wen wrong Error occured.\n")
      }
    }
  }
  //Function for Recursive approach
  def recursivePermute(data:Array[Char], pos :Int):Unit =
    {
    if(pos == data.length - 1){
      print(String.valueOf(data)+" ")
    }else{
      for(i <-pos until data.length){

        var temp_char = data(pos)
        data(pos) = data(i)
        data(i) = temp_char

        recursivePermute(data,pos+1)

        temp_char = data(pos)
        data(pos) = data(i)
        data(i) = temp_char

      }
    }
  }
  // Function for iterative approach
  def iterativePermute(word: String):Unit ={

    var data = new util.ArrayList[String]()
    data.add(String.valueOf(word.charAt(0)))

    for(i <- 1 until word.length){
      for(j <- data.size()-1 to 0 by -1){
        var str = data.remove(j)
        for(k <- 0 to str.length){
          data.add(str.substring(0,k)+word.charAt(i)+str.substring(k))
        }
      }
    }
    print("\n"+data)
  }
}







