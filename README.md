# Compilador

# Gramática 
* E -> E+T | E-T | T

* T -> T*P | T/P | P

* P -> P^F | exp[F] | F

* F -> (E) | id

# Tipo Preditivo não recursivo
* E  -> TE'
* E' -> +TE' | -TE' | e
* T  -> PT'
* T' -> *PT' | /PT' | e
* P  -> EXP[F]P' | FP'
* P' -> ^FP' | e
* F  -> (E) | id

# Realiza operações do tipo

* 1+2*3^4  			  163
* 
* (1+2)*3^4 			243
* 
* 1+(2*3)^4 			1297
* 
* 1+(2*3)+exp[4]  61,598150033


# Léxico

!["tabela"](./tabela_parsing.jpg)


# Sintático

### First 

* FIRST E -> {exp, (, id}
* FIRST E' -> {+ , - , e}
* FIRST T -> {exp, ( , id}
* FIRST T' -> {*, / , e} 
* FIRST P -> {exp , ( , id}
* FIRST P' -> {^ , e}
* FIRST F -> { ( , id}

### Follow 

* FOLLOW E -> { ) , $}
* FOLLOW E' ->  { ) , $}
* FOLLOW T -> { + , - , ) , $}
* FOLLOW T' -> { + , - , ) , $}
* FOLLOW P -> { *, / , + , - , ) , $}
* FOLLOW P' -> {* , / , + , - , ) , $}
* FOLLOW F -> { ] , ^ , * , / , + , - , ) , $}

# Tabela


# Semântica

#### Análise sintatica descendente L-atribuido


| Produção  | REGRA SEMÂNTICA   |
| ------- | -------- |
| E -> TE'   | E -> T{E'.inh = T.val} E'{E.val = E'.syn}   |
| E' -> + TE'   | E' -> +T{E'.inh = E'.inh + T.val} E'{E'.syn = E'.syn} |
| E' -> -TE'|E' -> -T{E'.inh = E'.inh - T.val} E'{E'.syn = E'.syn}   |
| E' -> &| E' -> &{E'.syn = E'.inh} |
| T -> PT'| T -> P{T'.inh = P.val} T'{T.val = T'.syn} |
| T' -> * PT' | T'-> * P{T'.inh = T'.inh ** P.val} T'{T'.syn = T'.syn} |
| T' -> / PT' | T'-> / P{T'.inh = T'.inh / P.val} T'{T'.syn = T'.syn} |
| T' -> &| T' -> &{T'.syn = T'.inh} |
| P -> FP' | P -> F{P'.inh = F.val} P'{P.val = P'.syn}|
| P -> exp[F]P'| P -> exp[F]{P'.inh = exp[F].val} P'{P.val = P'.syn}|
| P' -> ^FP'| P' -> ^F{P'.inh = P'.inh ^ F.val} P'{P'.syn = P'.syn}|
| P' -> &| P'-> &{P'.syn = P'.inh} |
| F -> id| F -> id{F.val = id.lexVal} |
| F -> (E) | F -> (E){F.val = (E).val}|
