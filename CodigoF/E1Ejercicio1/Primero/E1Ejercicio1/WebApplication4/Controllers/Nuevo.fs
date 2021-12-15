namespace WebApplication4

open System
open Microsoft.AspNetCore.Mvc
open System.Collections.Generic

type n = { name: string}

[<ApiController>]
[<Route("[controller]")>]
type Nuevo() =
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