namespace E1FEjericicio2.Controllers

open System
open System.Collections.Generic
open System.Linq
open System.Threading.Tasks
open Microsoft.AspNetCore.Mvc

[<Route("api/[controller]")>]
[<ApiController>]
type ValuesController () =
    inherit ControllerBase()

    let calculado x y z = 
        if (z = "Suma") then
            (fun a b -> a+b) x y
        elif (z = "Resta") then 
            (fun a b -> a-b) x y
        elif (z = "Multiplicacion") then 
            (fun a b -> a*b) x y
        else 
            (fun a b -> a/b) x y
    
    let res = calculado 5 4 "Suma"

    [<HttpGet>]
    member this.Get() = 
        base.Ok(res)
