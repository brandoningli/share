#Song Logger
#Record all the files stored in the Buffalo's iTunes music directory into a .csv file for usefulness
#2017 Brandon Ingli
#Run in Python 3.4+

#Will only work successfully if the songs are stored in this format: ..\Artist\Album\## Song.ext

from pathlib import Path
import codecs

rootdir = Path("Z:/music")

print("Searching for Songs...")

counter = 0

out = codecs.open("music_collection.csv", "w", "utf-8")
out.write("Artist,Album,Song #,Song\n") #Header

for f in rootdir.resolve().glob('**/*'):
    if f.is_file() and (str(f)[-3:] == "mp3" or str(f)[-3:] == "m4a"):
        song_info = str(f).split('\\')
        print("  =>Adding " + str(f))
        length = len(song_info)
        out.write("\""+song_info[length-3]+"\","+
              "\""+song_info[length-2]+"\","+
              "\""+song_info[length-1][:2]+"\","+
              "\""+song_info[length-1][3:-4]+"\"\n")
        counter = counter + 1
        if counter > 10:
            break

out.close()
