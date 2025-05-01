#!/bin/bash

while true; do
  echo ""
  echo "Which project would you like to run?"
  echo "-----------------------------------"
  echo ""
  echo "1. Tax Enforcement Management System"
  echo "2. Tax Management System"
  echo "3. Internship Management System"
  echo ""
  read -p "Enter choice (hit Enter to 'Quit'): " choice

  case $choice in
    2)
      echo "starting the Tax Management System ..."
      echo ""
      cd taxmanagementsys
      javac -d . $(find . -name "*.java")
      java taxmanagementsys.Main
      break
      ;;
    1)
      echo "starting the Tax Enforcement Management System ..."
      echo ""
      cd taxenfmansys
      javac -d . $(find . -name "*.java")
      java taxenfmansys.Main
      break

      ;;
    3)
      echo "starting the Internship Management System ..."
      echo ""
      cd internshipmansys
      javac -d . $(find . -name "*.java")
      java internshipmansys.Main
      break
      ;;
    "")
      echo ""
      echo "Ending....."
      exit 0
      ;;
    *)
      echo ""
      echo "Invalid choice. Please try again."
      ;;
  esac
done