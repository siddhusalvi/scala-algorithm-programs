/*
Filename: message_demon
Created: Siddhesh Salvi
Change history:4.2.2020 / Siddhesh Salvi

12. Customize Message Demonstration using String Function and RegEx
a. Desc -> Read in the following message: Hello <<name>>, We have your full
name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx.
Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.
Use Regex to replace name, full name, Mobile#, and Date with proper value.
b. I/P -> read in the Message
c. Logic -> Use Regex to do the following
i. Replace <<name>> by first name of the user ( assume you are the user)
ii. replace <<full name>> by user full name.
iii. replace any occurance of mobile number that should be in format
91-xxxxxxxxxx by your contact number.
iv. replace any date in the format XX/XX/XXXX by current date.
d. O/P -> Print the Modified Message.
*/

import java.util.Date
import java.text.SimpleDateFormat
object message_demon{
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        val regex_phone = "(0/91)?[7-9][0-9]{9}"
        var Msg = " Hello <<name>>, We have your fullname as <<full name>> in our system. your contact number is 91-<<number>>.\nPlease,let us know in case of any clarification Thank you BridgeLabz <<date>>."
        var full_name, number, name : String = null
        print("Enter your full name : ")
        full_name = scala.io.StdIn.readLine()

        name = getFirstName(full_name)

        print("Enter your Contact number :")
        number= scala.io.StdIn.readLine()
        if(number.matches(regex_phone)){
          flag = false
        }

        var date = new Date()
        var fm = new SimpleDateFormat("dd/MM/yyyy")
        var curDate: String = fm.format(date)

        Msg = Msg.replace("<<name>>",name)
        Msg = Msg.replace("<<full name>>",full_name)
        Msg = Msg.replace("<<number>>",number)
        Msg = Msg.replace("<<date>>",curDate)

        println(Msg)
      }
      catch{
        case _=>print("Something went wrong Error occurred.")
      }
    }
  }
  def getFirstName(fullName:String):String ={
    var i : Int  = 0
    while(fullName.charAt(i).asDigit != " ".charAt(0).asDigit){
      i += 1
    }
    fullName.substring(0,i)
  }
}