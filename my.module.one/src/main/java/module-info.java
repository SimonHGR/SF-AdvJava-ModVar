import apackage.MyServiceIF;

/*open*/ module my.module.one {
  // this means "public stuff in this named PACKAGE"
  // shall be available to clients of this module
  exports apackage to my.client.module, bad.module.one;
  opens apackage to my.client.module, bad.module.one, bad.module.two;
  provides MyServiceIF with nonpublic.Stuff, otherhidden.MoreSecrets;
}
