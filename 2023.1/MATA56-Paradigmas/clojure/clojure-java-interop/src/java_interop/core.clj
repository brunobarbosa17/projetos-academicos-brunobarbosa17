(ns java-interop.core
  (:gen-class)
  (:import (car Car)))


(.toJson (new Car "Toyota"))

(.getFabricante (new Car "Toyota"))

