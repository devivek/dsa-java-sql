root="/Users/v/dev/dsa-java-sql/DSA"
cd $root

# compile
javac -d ${root}/temp/ Run.java
cd ${root}/temp
java Run

# delete temp folder
cd ${root}
rm -r ${root}/temp

# sync
git add .
git commit -m "sync-for-date-$(date +"%Y-%m-%d")"
git push origin