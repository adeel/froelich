(ns froelich.core
  (:require [goog.dom :as gdom]
            [goog.dom.classes :as gclasses]
            [goog.dom.query :as gquery]))

;; selectors

(defn get-by-id [id]
  (.getElementById js/document (name id)))

(defn get-by-class [klass container]
  (gdom/getElementsByClass (name klass) container))

(defn get [tag klass container]
  (gdom/getElementsByTagNameAndClass (name tag) (name klass) container))

(defn query [selector container]
  (gdom.query selector container))

(comment
  (dom/get-by-class :child (dom/get-by-id :container))
  (dom/get :div :child (dom/get-by-id :container))
  (dom/query "div.child" (dom/get-by-id :container)))

;; related

(defn get-children [el]
  (gdom/getChildren el))

(defn get-next [el]
  (gdom/getNextNode el))

(defn get-previous [el]
  (gdom/getPreviousNode el))

;; manipulation

(defn append! [el container]
  (gdom/appendChild container el))

(defn remove! [el]
  (gdom/removeNode el))

;; classes

(defn get-classes [el]
  (gdom.classes/get el))

(defn has-class? [el klass]
  (gdom/classes/has el klass))

(defn add-class! [el & classes]
  (apply (partial gdom.classes/add el) classes))

(defn remove-class! [el & classes]
  (apply (partial gdom.classes/remove el) classes))

(defn toggle-class! [el klass]
  (gdom.classes/toggle el klass))