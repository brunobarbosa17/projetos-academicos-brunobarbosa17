(defn nomeIdade [nome idade] (str "Meu nome e: " nome "Minha idade e: " idade))

(println(nomeIdade "Bruno" 23))


(println type true)

(defn sum-of-numbers [x y]
(println (format "x + y = %d" (+ x y))))

(sum-of-numbers 10 25)


(defn maiorQueZero [num] (if (> num 0) "verdadeiro" "falso"))
(defn maiorQueZero [num] (> num 0))
(println maiorQueZero 2)

(def produtos [
    {:nome "Uva" :quantidade 5}
    {:nome "Banana" :quantidade 2}
    {:nome "Laranja" :quantidade 3}
    {:nome "Melancia" :quantidade 10}
    {:nome "Aipim" :quantidade 0}
    {:nome "Abacaxi" :quantidade 0}
    {:nome "Pera" :quantidade 20}
])
(defn estaDisponivel [produto] (> (:quantidade produto) 0))
(defn produtosDisponiveis [produto] (filter estaDisponivel produtos))
;; OU
(filter estaDisponivel produtos)
;; ({:nome "Uva", :quantidade 5} {:nome "Banana", :quantidade 2} {:nome "Laranja", :quantidade 3} {:nome "Melancia", :quantidade 10} {:nome "Pera", :quantidade 20})


(let [d (java.util.Date.)]
  (. d getTime))  ; ⇒ 1349819873183

(doto (java.util.Stack.)
  (.push 42)
  (.push 13)
  (.push 7))  ; ⇒ [42, 13, 7]>

(defn repetir [n]
  (loop [contador 0]
    (if (< contador n)
      (do
        ;; Corpo da repetição
        (println "Executando repetição" contador)
        (recur (inc contador)))
      nil)))

(repetir 5)










(for [i (range 10)] (println "nao aceito fiado, volte amanha "  i))