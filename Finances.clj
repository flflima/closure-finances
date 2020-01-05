(def transacoes [{:valor 1000 :tipo "despesa" :descricao "compra supermercado"} {:valor 80.90 :tipo "despesa" :descricao "remedios"} {:valor 50.00 :tipo "receita" :descricao "rendimento poupanca"}])

(defn valor-sinalizado [transacao]
	(if (= (:tipo transacao) "despesa")
		(str "-" (:valor transacao))
		(str "+" (:valor transacao))	
	)	
)

(map valor-sinalizado transacoes)

;;

(def transacoes [{:moeda "R$" :valor 1000 :tipo "despesa" :descricao "compra supermercado"} {:moeda "R$" :valor 80.90 :tipo "despesa" :descricao "remedios"} {:moeda "R$" :valor 50.00 :tipo "receita" :descricao "rendimento poupanca"}])


(defn valor-sinalizado [transacao]
	(if (= (:tipo transacao) "despesa")
		(str (:moeda transacao) " -" (:valor transacao))
		(str (:moeda transacao) " +" (:valor transacao))	
	)	
)

(map valor-sinalizado transacoes)


;;

(defn valor-sinalizado [transacao]
	(let [moeda (:moeda transacao) valor (:valor transacao)]
		(if (= (:tipo transacao) "despesa")
			(str moeda " -" valor)
			(str moeda " +" valor)	
		)
	)	
)

(map valor-sinalizado transacoes)

;;

(def transacao-aleatoria {:valor 1000 :tipo "despesa" :descricao "compra supermercado"})

(defn valor-sinalizado [transacao]
	(let [moeda (:moeda transacao "R$") valor (:valor transacao)]
		(if (= (:tipo transacao) "despesa")
			(str moeda " -" valor)
			(str moeda " +" valor)	
		)
	)	
)

(map valor-sinalizado transacoes)
(valor-sinalizado transacao-aleatoria)

;;

(def transacoes [{:valor 1000 :tipo "despesa" :descricao "compra supermercado" :data "12/2/2019"} {:valor 80.90 :tipo "despesa" :descricao "remedios" :data "12/2/2019"} {:valor 50.00 :tipo "receita" :descricao "rendimento poupanca" :data "12/2/2019"}])


(defn data-valor [transacao]
	(let [data (:data transacao)]
		(str data " => " (valor-sinalizado transacao))
	)	
)

(map data-valor transacoes)

;;










