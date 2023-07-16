;; QUESTAO 1
(defun factorial (num)
  (if (not (integerp num))
      (format t "O numero deve ser inteiro")
      (if (< num 0)
          (format t "O numero deve ser maior do que zero")
          (if (<= num 1)
              1
              (* num (factorial (- num 1)))))))
(let ((num (read)))
  (format t "O fatorial de ~a é ~a.~%" num (factorial num)))

;; QUESTAO 2
(defun palindromo (palavra)
  (equal palavra (reverse palavra))
  )  
(if (palindromo "ana")
    (princ "e palindromo")
    (princ "Nao e palindromo"))
    

;; QUESTAO 3
(defun n-fibonacci (n)
  (if (or (zerop n) (= n 1))
      n
      (+ (n-fibonacci (- n 1))
         (n-fibonacci (- n 2)))))

(format t "Ïnforme o numero do elemento da sequencia de Fibonacci desejado: ")
(let ((n (parse-integer (read-line))))
  (format t "O n-esimo numero da sequencia e: ~a.~%" (n-fibonacci n)))


;; QUESTAO 4
(defun sortedp (list)
  (cond ((endp (rest list)) t) 
        ((> (first list) (second list)) nil)
        (t (sortedp (rest list)))))
(if (sortedp '(1 2 3 4 5))
    (princ "A lista está ordenada")
    (princ "A lista não está ordenada"))

    