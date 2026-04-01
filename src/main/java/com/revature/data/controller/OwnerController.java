package com.revature.data.controller;

import com.revature.data.entity.Owner;
import com.revature.data.repo.OwnerRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owner")
public class OwnerController {

    private final OwnerRepo repo;

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner){
        return repo.save(owner);
    }

    @GetMapping
    public List<Owner> getAllOwners(){
        return repo.findAll();
    }

    @GetMapping("/{owner}")
    public Owner getOwnerByName(@PathVariable("owner") String owner){
        Optional<Owner> possibleOwner = repo.findByName(owner);
        if(possibleOwner.isPresent()){
            return possibleOwner.get();
        } else {
            return new Owner();
        }
    }

    @GetMapping("/all")
    public List<String> getAllOwnerNamesUppercase(){
        return repo.findAndMakeOwnersUppercase();
    }

    @PutMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Owner> allFailTogether(){
        Owner ownerOne = new Owner();
        ownerOne.setName("Sally");
        Owner ownerTwo = new Owner();
        ownerTwo.setName("Billy");
        repo.save(ownerOne);
        repo.save(ownerTwo);
        throw new RuntimeException("manually failing route");
      //  return repo.findAll();
    }

}

