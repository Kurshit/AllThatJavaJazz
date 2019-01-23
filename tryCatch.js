var f1 = function()
{
   print.log(kuku);
}

try
{
  f1();
}
catch(e if e instanceof ReferenceError | e instanceof TypeError)
{
  print("hehe");
}

