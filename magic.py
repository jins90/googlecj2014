f = open("input.txt", "r")
line = f.readline()
cases = int(line.strip())

for i in range(cases):
   guess1 = f.readline().strip()
   grid1 = []
   for j in range(4):
      line = f.readline().strip()
      args = line.split(' ')
      grid1.append(args)
   guess2 = f.readline().strip()
   grid2 = []
   for j in range(4): 
      line = f.readline().strip()
      args = line.split(' ')
      grid2.append(args)
   row1 = int(guess1) - 1
   row2 = int(guess2) - 1

   find1 = grid1[row1]
   find2 = grid2[row2]
   count = 0
   val = ''
   for x in find1:
      for y in find2:
         if(x == y):
            val = x
            count += 1 
   r = 'Case #'
   if(count == 0):
      r += str(i + 1) + ': Volunteer cheated!'
   elif(count == 1):
      r += str(i + 1) + ':' + ' ' + str(val)
   else: 
      r += str(i + 1) + ': Bad magician!' 
   print r
