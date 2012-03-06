(ns froelich.core
  (:require goog.dom
            goog.dom.classes
            goog.dom.query))

;; selectors

(defn get-by-id [id]
  (.getElementById js/document (name id)))

(defn get-by-class [klass container]
  (goog.dom/getElementsByClass (name klass) container))

(defn get [tag klass container]
  (goog.dom/getElementsByTagNameAndClass (name tag) (name klass) container))

(defn query [selector container]
  (goog.dom.query selector container))

(comment
  (dom/get-by-class :child (dom/get-by-id :container))
  (dom/get :div :child (dom/get-by-id :container))
  (dom/query "div.child" (dom/get-by-id :container)))

;; related

(defn get-children [el]
  (goog.dom/getChildren el))

(defn get-next [el]
  (goog.dom/getNextNode el))

(defn get-previous [el]
  (goog.dom/getPreviousNode el))

;; manipulation

(defn append! [el container]
  (goog.dom/appendChild container el))

(defn remove! [el]
  (goog.dom/removeNode el))

;; classes

(defn get-classes [el]
  (goog.dom.classes/get el))

(defn has-class? [el klass]
  (goog.dom/classes/has el klass))

(defn add-class! [el & classes]
  (apply (partial goog.dom.classes/add el) classes))

(defn remove-class! [el & classes]
  (apply (partial goog.dom.classes/remove el) classes))

(defn toggle-class! [el klass]
  (goog.dom.classes/toggle el klass))