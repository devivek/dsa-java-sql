root="/Users/mw-vivek/vkg/dsa-java-sql/DSA"
cd $root

# compile
mkdir temp
javac -d ${root}/temp/ Run.java
cd ${root}/temp
java Run

# delete temp folder
cd ${root}
rm -r ${root}/temp

# sync
random_number=$((RANDOM % 15))
echo "Random Number - ${random_number}"
# Check if the random number is 1
if [ "$random_number" -eq 11 ]; then
    # Your code here
    git add .
    git commit -m "sync-for-date-$(date +"%Y-%m-%d")"
    git push origin
fi
