(ns draw-test.core
  (:use [mikera.image core colours])
  (:require [mikera.image.filters :as filt]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


;; load an image from a resource file
;;(def ant (load-image-resource "WIN_20141231_102624.JPG"))

(def size 600)

;; create a new image
(def bi  (new-image  size size))

;; gets the pixels of the image, as an int array
(def pixels  (get-pixels bi))

(defn set-rgb [buf x y r g b]
  (let [color (rgb r g b)]
    (aset buf (+ x (* y size)) color)))

(defn demo []

  ;; fill some random pixels with colours
  (dotimes [i (* size size)]
;;    (aset pixels i (rand-colour)))
    (aset pixels i (rgb 0 1 0)))

  (dotimes [i 200]
    (dotimes [j 200]
      (set-rgb  pixels (+ 200 i) (+ j 200) 1 0 0)))

  ;; update the image with the newly changed pixel values
  (set-pixels bi pixels)

  ;; view our new work of art
  ;; the zoom function will automatically interpolate the pixel values
  (show bi :zoom 1.0 :title ""))

(defn -main [& args]
  ;; show the iamge, after applying an "invert" filter
  ;;(show (filter-image ant (filt/invert)))
  (demo))
