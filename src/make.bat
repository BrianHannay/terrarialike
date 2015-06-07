@echo off
echo "Compiling"
javac -d ../bin/ *.java && echo "Git add" && cd ../ && git add -A . && echo "Git commit" && git commit -m "Autocommit from SublimeText2" && echo "Git push" && git push origin master && echo "Starting program" && cd bin && java Window