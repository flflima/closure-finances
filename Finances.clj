(def transacoes [{:valor 29 :tipo "despesa" :descricao "compra supermercado"} {:valor 80.90 :tipo "despesa" :descricao "remedios"} {:valor 50.00 :tipo "receita" :descricao "rendimento poupanca"}])

(defn valor-sinalizado [transacao]
	(if (= (:tipo transacao) "despesa")
		(str "-" (:valor transacao))
		(str "+" (:valor transacao))	
	)	
)

(map valor-sinalizado transacoes)

;;

(def transacoes [{:moeda "R$" :valor 29 :tipo "despesa" :descricao "compra supermercado"} {:moeda "R$" :valor 80.90 :tipo "despesa" :descricao "remedios"} {:moeda "R$" :valor 50.00 :tipo "receita" :descricao "rendimento poupanca"}])


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

(def transacoes [{:valor 29 :tipo "despesa" :descricao "compra supermercado" :data "12/2/2019"} {:valor 80.90 :tipo "despesa" :descricao "remedios" :data "12/2/2019"} {:valor 50.00 :tipo "receita" :descricao "rendimento poupanca" :data "12/2/2019"}])


(defn data-valor [transacao]
	(let [data (:data transacao)]
		(str data " => " (valor-sinalizado transacao))
	)	
)

(map data-valor transacoes)

;;

;; cotacoes

(def cotacoes {:yuan {:cotacao 2.15 :simbolo "¥"}})

(defn transacao-em-yuan [transacao]
	(assoc transacao :valor (* (:cotacao (:yuan cotacoes))
														 (:valor transacao))
									 :moeda (:simbolo (:yuan cotacoes)))
)

;;


(defn transacao-em-yuan [transacao]
	(assoc transacao :valor (* (get-in cotacoes [:yuan :cotacao])
														 (:valor transacao))
									 :moeda (get-in cotacoes [:yuan :simbolo]))
)

;;


(defn transacao-em-yuan [transacao]
	(let [yuan (:yuan cotacoes)]
		(assoc transacao :valor (* (:cotacao yuan) (:valor transacao))
										 :moeda (:simbolo yuan))
	)
)

(map transacao-em-yuan transacoes)
(transacao-em-yuan (first transacoes))

;;


(data-valor (first transacoes))
(data-valor (transacao-em-yuan (first transacoes)))

;;

(defn texto-resumo-em-yuan [transacao]
	(data-valor (transacao-em-yuan transacao)))
)

(map texto-resumo-em-yuan transacoes)

;; com bigdecimal

(class 3.1)
(* 3.1 3.1)
(class 3.1M)
(* 3.1M 3.1)
(* 3.1M 3.1M)
(class (* 3.1M 3.1M))


(def cotacoes {:yuan {:cotacao 2.15M :simbolo "¥"}})

(def transacoes [{:valor 29M :tipo "despesa" :descricao "compra supermercado" :data "12/2/2019"} {:valor 80.90M :tipo "despesa" :descricao "remedios" :data "12/2/2019"} {:valor 50.00M :tipo "receita" :descricao "rendimento poupanca" :data "12/2/2019"}])

(map texto-resumo-em-yuan transacoes)

;; macro thread-first

(defn texto-resumo-em-yuan [transacao]
	(-> (transacao-em-yuan transacao)
			(data-valor))
)

;;









