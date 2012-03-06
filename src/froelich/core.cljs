(ns froelich.core
  (:require [goog.dom :as gdom]
            [goog.dom.classes :as gclasses]))


(defn- collection-to-vec [coll]
  (map (fn [i] (.item coll i)) (range 0 (.-length coll))))

;; selectors

(defn get-by-id [id]
  (.getElementById js/document (name id)))

(defn get-by-class [klass container]
  (collection-to-vec (gdom/getElementsByClass (name klass) container)))

(defn get-by-tag-and-class [tag klass container]
  (collection-to-vec
    (gdom/getElementsByTagNameAndClass (name tag) (name klass) container)))

(comment
  (dom/get-by-class :child (dom/get-by-id :container))
  (dom/get-by-tag-and-class :div :child (dom/get-by-id :container)))

;; related

(defn get-children [el]
  (collection-to-vec (gdom/getChildren el)))

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
  (map keyword (gclasses/get el)))

(defn has-class? [el klass]
  (gclasses/has el (name klass)))

(defn add-class! [el & classes]
  (apply (partial gclasses/add el) (map name classes)))

(defn remove-class! [el & classes]
  (apply (partial gclasses/remove el) (map name classes)))

(defn toggle-class! [el klass]
  (gclasses/toggle el (name klass)))