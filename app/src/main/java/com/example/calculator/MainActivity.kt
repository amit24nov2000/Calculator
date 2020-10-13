package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view: View) {
        if(isNewOp)
            etShowNumber.setText("")
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=etShowNumber.text.toString()
        when(buSelect.id){
            bu0.id->{buClickValue+="0"}
            bu1.id->{buClickValue+="1"}
            bu2.id->{buClickValue+="2"}
            bu3.id->{buClickValue+="3"}
            bu4.id->{buClickValue+="4"}
            bu5.id->{buClickValue+="5"}
            bu6.id->{buClickValue+="6"}
            bu7.id->{buClickValue+="7"}
            bu8.id->{buClickValue+="8"}
            bu9.id->{buClickValue+="9"}
            //TODO: prevent adding more than 1 dot
            buDot.id->{buClickValue+="."}
            buPlusMinus.id->{buClickValue+="-"}
        }
        etShowNumber.setText(buClickValue)
    }
    var op="*"
    var oldNumber=""
    var isNewOp=true
    fun buOpEvent(view: View) {
        val buSelect= view as Button
        when(buSelect.id){
            buMul.id->{ op="*"}
            buDiv.id->{ op="/"}
            buSub.id->{ op="-"}
            buSum.id->{ op="+"}
            buSin.id->{ op="sin"}
            buCos.id->{ op="cos"}
            buTan.id->{ op="tan"}
            buLog.id->{ op="log"}
            buLn.id->{ op="ln"}
            buSqrt.id->{ op="√"}
            //buSquare.id->{ op="square"}
            //buInverse.id->{ op="inverse"}
            }
        oldNumber=etShowNumber.text.toString()
        etShowNumber.setText(op)
        etShowNumber2.setText(oldNumber+op)
        isNewOp=true
    }

    fun buEqualEvent(view: View) {
        var newNumber=etShowNumber.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->{finalNumber=oldNumber.toDouble()*newNumber.toDouble()
                  etShowNumber2.setText(oldNumber+op+newNumber)}
            "/"->{finalNumber=oldNumber.toDouble()/newNumber.toDouble()
                etShowNumber2.setText(oldNumber+op+newNumber)}
            "+"->{finalNumber=oldNumber.toDouble()+newNumber.toDouble()
                etShowNumber2.setText(oldNumber+op+newNumber)}
            "-"->{finalNumber=oldNumber.toDouble()-newNumber.toDouble()
                etShowNumber2.setText(oldNumber+op+newNumber)}
            "sin"->{finalNumber=Math.sin(newNumber.toDouble()*Math.PI/180.0)
                etShowNumber2.setText(op+newNumber)}
            "cos"->{finalNumber=Math.cos(newNumber.toDouble()*Math.PI/180.0)
                etShowNumber2.setText(op+newNumber)}
            "tan"->{finalNumber=Math.tan(newNumber.toDouble()*Math.PI/180.0)
                etShowNumber2.setText(op+newNumber)}
            "log"->{finalNumber=Math.log10(newNumber.toDouble())
                etShowNumber2.setText(op+newNumber)}
            "ln"->{finalNumber=Math.log(newNumber.toDouble())
                etShowNumber2.setText(op+newNumber)}
            "√"->{finalNumber=Math.sqrt(newNumber.toDouble())
                etShowNumber2.setText(op+newNumber)}
            //"square"->{finalNumber=(newNumber.toDouble()*newNumber.toDouble())}
            //"inverse"->{finalNumber=1/(newNumber.toDouble())}

        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buPercentEvent(view: View) {
        var number=etShowNumber.text.toString().toDouble()/100
        etShowNumber.setText(number.toString())
    }

    fun buCleanEvent(view: View) {
        etShowNumber.setText("")
        etShowNumber2.setText("")
        isNewOp=true
    }

    fun buCEvent(view: View) {
        var Clear=etShowNumber.text.toString()
        etShowNumber.setText(Clear.dropLast(1))
    }

    fun buPieEvent(view: View) {
        etShowNumber.setText("")
        val pi= Math.PI
        etShowNumber.setText(pi.toString())

    }

    fun buFactEvent(view: View) {
        var fact=etShowNumber.text.toString().toLong()
        etShowNumber2.setText("$fact"+"!")
        var f:Long=1
        for(i in 1..fact){
            f *= i
        }
        etShowNumber.setText(f.toString())
    }

    fun buInverseEvent(view: View) {
        var INV=etShowNumber.text.toString()
        etShowNumber2.setText("1/"+"$INV")
        var inv:Double=1/(etShowNumber.text.toString().toDouble())
        etShowNumber.setText(inv.toString())
    }

    fun buSquareEvent(view: View) {
        var INV=etShowNumber.text.toString()
        etShowNumber2.setText("($INV)^2")
        var inv:Double=INV.toDouble()*INV.toDouble()
        etShowNumber.setText(inv.toString())
    }
}