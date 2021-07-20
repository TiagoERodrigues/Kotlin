fun main(args: Array<String>) {
    println("Bem Vindo!")
/*
= readLine()
= Integer.valueOf(readLine())
 */
    val pessoa = Pessoa()

    println("Digite seu nome: ")
    pessoa.nome = readLine().toString()
    println("Seja bem vindo, ${pessoa.nome}")
    println("Digite seu salário: ")
    pessoa.salario = Integer.valueOf(readLine()).toDouble()
    pessoa.despesa = 0.0

    var opc = 0
    do {
        println("1- Cadastrar Despesas")
        println("2- Calcular Despesas")
        println("3- Reajustar Despesas")
        println("4- Sair\n")
        opc = Integer.valueOf(readLine())

        when (opc) {
            1 -> {
                pessoa.CadastrarDespesas(pessoa.despesa)
            }
            2 -> {
                pessoa.CalcularDespesas(pessoa.salario, pessoa.despesa)
            }
        }

    } while (opc != 4)


}

class Pessoa {

    var nome = ""
    var salario = 0.0
    var despesa = 0.0

    fun CadastrarDespesas(despesa: Double): Double {

        var opc = 0
        var aux = 0.0
        println("Quantas despesas você possui?")
        opc = Integer.valueOf(readLine())

        for (i in 1..opc) {
            println("Valor da despesa: ")
            this.despesa = Integer.valueOf(readLine()).toDouble()
            aux += this.despesa
        }
        this.despesa = aux
        println("Valor total das despesas: ${this.despesa}\n")
        return despesa

    }

    fun CalcularDespesas(salario: Double, despesa: Double) {

        when {
            despesa == 0.0 -> {

                println("Suas despesas não estão cadastradas. Redirecionando para o cadastro")
                CadastrarDespesas(despesa)

            }
            salario < despesa -> {

                this.salario -= despesa
                println("Suas despesas são maiores que seu salário")
                println("Valor mensal final de: $salario")

            }
            salario > despesa -> {

                this.salario -= despesa
                println("Valor mensal final de: ${this.salario}\n")

            }
        }
    }
}

