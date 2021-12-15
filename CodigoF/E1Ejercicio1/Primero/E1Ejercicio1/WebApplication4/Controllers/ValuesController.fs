namespace WebApplication4.Controllers

open System
open System.Collections.Generic
open System.Linq
open System.Threading.Tasks
open Microsoft.AspNetCore.Mvc

[<Route("api/[controller]")>]
[<ApiController>]
type ValuesController () =
    inherit ControllerBase()

    let rec fibonacci x = 
        if (x < 3) then
            0
        elif (x < 5) then 
            1
        else 
            fibonacci (x - 1) + fibonacci (x - 2)
    
    let cad (x: int) = string x

    let n = cad(fibonacci 1) + " " + cad(fibonacci 2) + " " + cad(fibonacci 3) + " " + cad(fibonacci 4) + " " + cad(fibonacci 5)

    [<HttpGet>]
    member this.Get() = 
        base.Ok(n)
