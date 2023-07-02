#!/bin/bash

chemin=$1

javac -d ${chemin} @compile.list
cp ./plan.txt ${chemin}/graphe/
